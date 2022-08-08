package com.luanhroliveira.application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RaceApplication {

    //PARAMETERS
    private static Integer laps = 10;
    private static Integer numberOfCompetitors = 10;

    private final Map<String, Long> data = new HashMap<>();
    private final Map<String, Integer> lapCounterPerCompetitor = new HashMap<>();
    private final List<Competitor> competitors = new ArrayList<>();

    public RaceApplication() throws InterruptedException {
        System.out.println("Preparing race...");

        if (getLaps() < 10) {
            setLaps(10);
        }
        if (getNumberOfCompetitors() < 10) {
            setNumberOfCompetitors(10);
        }

        final var threads = new ArrayList<Thread>();

        for (int i = 1; i <= getNumberOfCompetitors(); i++) {
            final var competitorName = "Competitor #" + i;

            this.getLapCounterPerCompetitor().put(competitorName, 0);

            threads.add(
                new CompetitorThread(
                    new Competitor(competitorName, 0L)
                )
            );
        }

        System.out.println("Starting race!");
        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("############################");

        final var sortedCompetitorList =
            this.getCompetitors()
                .stream()
                .sorted(Comparator.comparing(Competitor::getScore).reversed())
                .toList();

        final var podiumList = new ArrayList<Competitor>();

        for (Competitor c : sortedCompetitorList) {
            if (podiumList.size() < 3) {
                podiumList.add(c);
            }
        }

        System.out.println("\n==== Podio ====");
        podiumList
            .forEach(competitor -> System.out.println(competitor.getName() + " com " + competitor.getScore() + " pontos"));

        System.out.println("\n==== Tabela de pontos ====");
        sortedCompetitorList
            .forEach(competitor -> System.out.println(competitor.getName() + " com " + competitor.getScore() + " pontos"));

        System.out.println("Finish!!!");
    }

    public synchronized void recordScore(final String threadName, final Integer lap) {
        final long finishedTheLapCount = this.getFinishedTheLapCount(threadName);

        this.getLapCounterPerCompetitor().put(threadName, lap);

        long score;
        if (this.getData().containsKey(threadName)) {
            score = (10L - finishedTheLapCount) + this.getData().get(threadName);
        } else {
            score = 10L - finishedTheLapCount;
        }
        this.getData().put(threadName, score);

        this.updateCompetitorsScore(threadName, score);
    }

    private Long getFinishedTheLapCount(final String threadName) {
        return this.getLapCounterPerCompetitor()
            .values()
            .stream()
            .filter(value -> this.getLapCounterPerCompetitor().get(threadName).equals(value))
            .count();
    }

    private void updateCompetitorsScore(final String threadName, final Long score) {
        this.getCompetitors().forEach(x -> {
            if (x.getName().equals(threadName)) {
                x.setScore(score);
            }
        });
    }

    public Map<String, Long> getData() {
        return data;
    }

    public Map<String, Integer> getLapCounterPerCompetitor() {
        return lapCounterPerCompetitor;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void addCompetitor(Competitor competitor) {
        this.competitors.add(competitor);
    }

    public static Integer getLaps() {
        return laps;
    }

    public static void setLaps(Integer laps) {
        RaceApplication.laps = laps;
    }

    public static Integer getNumberOfCompetitors() {
        return numberOfCompetitors;
    }

    public static void setNumberOfCompetitors(Integer numberOfCompetitors) {
        RaceApplication.numberOfCompetitors = numberOfCompetitors;
    }

    class CompetitorThread extends Thread {
        private Thread thread;

        public CompetitorThread(Competitor competitor) {
            addCompetitor(competitor);
            this.setThread(new Thread(this, competitor.getName()));
        }

        @Override
        public void run() {
            System.out.println("Starting Thread: " + this.getThread().getName());

            try {
                for (int i = 1; i <= laps; i++) {
                    System.out.println(this.getThread().getName() + " lap: " + i);

                    Thread.sleep(ThreadLocalRandom.current().nextInt(10, 10000));

                    recordScore(this.getThread().getName(), i);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Finish Thread " + this.getThread().getName());
        }

        public Thread getThread() {
            return thread;
        }

        public void setThread(Thread thread) {
            this.thread = thread;
        }
    }

    static class Competitor {
        private String name;
        private Long score;

        public Competitor(String name, Long score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getScore() {
            return score;
        }

        public void setScore(Long score) {
            this.score = score;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new RaceApplication();
    }
}