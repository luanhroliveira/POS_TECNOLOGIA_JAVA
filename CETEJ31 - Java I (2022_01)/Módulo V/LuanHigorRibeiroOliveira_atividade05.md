### 1. Na tecnologia Java, defina o que são e para que servem as Classes Wrappers.

- Uma classe do tipo Wrapper em Java é usada para conversão de um determinado tipo de dado primitivo para objeto e de
  objeto para primitivo. E também armazenam os seus dados na memória heap enquanto as variáveis locais preservadas na
  pilha. O valor default para atributos de referência (objetos) é null.

### 2. De forma sucinta, comente a aplicação das seguintes classes:

- **a. Integer:**

    - A classe Integer fornece vários métodos de conversão de int para String e vice-versa, e tbm possui outros métodos
      de conversão dos mais diversos tipos de variáveis.

- **b. Boolean:**

    - A classe Boolean fornece vários métodos de conversão de boolean para String e vice-versa, e tbm possui outros
      métodos de conversão dos mais diversos tipos de variáveis.

- **c. Character:**

    - A classe Character fornece vários métodos de conversão de char para String e vice-versa, e tbm possui outros
      métodos de conversão dos mais diversos tipos de variáveis.

      Além disso, fornece métodos capazes de converter caracteres de maiúsculas para minúsculas, e vice-versa.

- **d. Double:**

    - A classe Double fornece vários métodos de conversão de double para String e vice-versa, e tbm possui outros
      métodos de conversão dos mais diversos tipos de variáveis.

- **e. Byte:**

    - A classe Byte fornece vários métodos de conversão de byte para String e vice-versa, e tbm possui outros métodos de
      conversão dos mais diversos tipos de variáveis.

- **f. Short:**

    - A classe Short fornece vários métodos de conversão de short para String e vice-versa, e tbm possui outros métodos
      de conversão dos mais diversos tipos de variáveis.

- **g. Float:**

    - A classe Float fornece vários métodos de conversão de float para String e vice-versa, e tbm possui outros métodos
      de conversão dos mais diversos tipos de variáveis.

- **h. Long:**

    - A classe Long fornece vários métodos de conversão de long para String e vice-versa, e tbm possui outros métodos de
      conversão dos mais diversos tipos de variáveis.

---

#### — De forma geral, como descrito no item 1, as classes Wrapper servem para fazer conversões de dados...

---

### 3. Considere as classes citadas no item “2”. Escolha 3 destas classes e construa um código simples que mostre um exemplo da sua aplicação para elas. Copie e cole o código de teste abaixo.

````java
public class Application {
    public static void main(String[] args) {

        /* Declaração das variáveis do tipo primitivo */
        int primitivoInt = 0;
        double primitivoDouble = 0;
        char primitivoChar = 0;
        boolean primitivoBoolean = false;

        System.out.println("primitivoInt: " + primitivoInt);
        System.out.println("primitivoDouble: " + primitivoDouble);
        System.out.println("primitivoChar: " + primitivoChar);
        System.out.println("primitivoBoolean: " + primitivoBoolean);

        /* Convertendo do primitivo para wrapper */
        Integer wrapperInteger = Integer.valueOf(primitivoInt);
        Double wrapperDouble = Double.valueOf(primitivoDouble);
        Character wrapperCharacter = Character.valueOf(primitivoChar);
        Boolean wrapperBoolean = Boolean.valueOf(primitivoBoolean);

        System.out.println("wrapperInteger: " + wrapperInteger);
        System.out.println("wrapperDouble: " + wrapperDouble);
        System.out.println("wrapperCharacter: " + wrapperCharacter);
        System.out.println("wrapperBoolean: " + wrapperBoolean);

        /* Convertendo de wrapper para primitivo */
        primitivoInt = wrapperInteger.intValue();
        primitivoDouble = wrapperDouble.doubleValue();
        primitivoChar = wrapperCharacter.charValue();
        primitivoBoolean = wrapperBoolean.booleanValue();

        System.out.println("primitivoInt: " + primitivoInt);
        System.out.println("primitivoDouble: " + primitivoDouble);
        System.out.println("primitivoChar: " + primitivoChar);
        System.out.println("primitivoBoolean: " + primitivoBoolean);
    }
}
````

---