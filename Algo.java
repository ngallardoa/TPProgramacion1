// import java.util.Scanner;

// public class Algo {

//     static void imprimirSuma(int a, int b) {
//         System.out.println(a + b);
// }

//     public static void main(String[] args) {
//         Scanner pedirPrimerNumero = new Scanner(System.in);
//         Scanner pedirSegundoNumero = new Scanner(System.in);
//         System.out.println("Ingrese el primer número a sumar");
//         int primerNumeroIngresado = pedirPrimerNumero.nextInt();
//         System.out.println("Ingrese el segundo número a sumar");
//         int segundoNumeroIngresado = pedirSegundoNumero.nextInt();
//         imprimirSuma(primerNumeroIngresado, segundoNumeroIngresado);
//     }
// } 

// import java.util.Scanner;

// public class Algo {

//     static String transformarString(String cadena){
//         String cadenaNueva = "";
//         cadenaNueva += cadena.charAt(0);
//         for (int i = 0; i < cadena.length() - 1; i++) {
//             if (cadena.charAt(i + 1) != cadena.charAt(i)) {
//                 cadenaNueva += cadena.charAt(i + 1);
//             }
//         }
//         return cadenaNueva;
//     }

//     public static void main(String[] args) {
//         Scanner pedirString = new Scanner(System.in);
//         System.out.println("Ingrese la palabra");
//         String stringIngresado = pedirString.nextLine();
//         String stringTransformado = transformarString(stringIngresado);
//         System.out.print("El string transformado es: " + stringTransformado);
//     }
// } 

// import java.util.Scanner;

// public class Algo {
//     static int mcd (int a, int b) {
//         if (a < 0 || b < 0) {
//             System.out.println("Alguno de los divisores es menor a 0");
//             return 0;
//         }
//         else {
//             if (a == 1 || b == 1) {

//             }
//         }
//         return mcd (a, b);
//     }
// }