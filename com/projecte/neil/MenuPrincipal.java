package com.projecte.neil;


import java.util.Scanner;


public class MenuPrincipal {

        boolean actiu = true;
        Scanner sc = new Scanner(System.in);

        public void run() {
            do{
                 System.out.println("\n╔══════════════════════════════════════╗");
                System.out.println("║   BENVINGUT/DA,                        ║");
                System.out.println("╚════════════════════════════════════════╝");
                System.out.println("[1]  Veure llistats generals");
                System.out.println("[2]  Afegir element a llista general");
                System.out.println("[3]  Eliminar element (només admin)");
                System.out.println("[4]  Veure les meves llistes personals");
                System.out.println("[5]  Afegir a les meves llistes");
                System.out.println("[6]  Eliminar de les meves llistes");
                System.out.println("[0]  Tancar sessió");
                System.out.print("\nOpció: ");

                int opcio = sc.nextInt();
                sc.nextLine();

                switch (opcio) {
                    case 1:
                        //mostrar llistats generals
                        break;
                    case 2:
                        //Afegir element a llista general
                        break;
                    case 3:
                        //Eliminar element (només admin)
                        break;
                    case 4:
                       //Veure les llistes propies
                       break;
                    case 5:
                        //Afegir a les meves llistes
                        break;
                    case 6:
                        //Eliminar de les meves llistes
                        break;
                    case 0:
                        actiu = false;
                        System.out.println("Sessió tancada.");
                        break;
                    default:
                        System.out.println("Opció no vàlida. Intenta-ho de nou.");
                }


            } while (actiu);
        }
            
           


}
