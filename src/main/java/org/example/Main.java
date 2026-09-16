package org.example;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //SLIDING WINDOW TEST
        int[] array = {1, 2, 3, 5};
        int tamanhoJanela = 4;

        FixedSlidingWindow janelaDeslizante = new FixedSlidingWindow();

        int[] resultado = janelaDeslizante.fixedSlidingWindow(array, tamanhoJanela);

        System.out.println("O resultado da soma máxima é: " + Arrays.toString(resultado));
    }
}