package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AnagramClass {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        // Se p for maior que s, é impossível existir um anagrama.
        if (p.length() > s.length()) {
            return result;
        }

        // Como temos apenas letras minúsculas de 'a' até 'z',
        // usamos arrays de tamanho 26 para armazenar frequências.
        int[] pFrequency = new int[26];
        int[] windowFrequency = new int[26];

        /*
         * Primeiro construímos:
         *
         * 1. Frequência das letras de p.
         * 2. Frequência da primeira janela de s,
         *    que terá tamanho igual a p.length().
         */
        for (int i = 0; i < p.length(); i++) {

            // Exemplo:
            // 'a' - 'a' = 0
            // 'b' - 'a' = 1
            // 'c' - 'a' = 2
            pFrequency[p.charAt(i) - 'a']++;

            windowFrequency[s.charAt(i) - 'a']++;
        }

        /*
         * Se as frequências forem iguais,
         * então a primeira janela é um anagrama.
         */
        if (Arrays.equals(pFrequency, windowFrequency)) {
            result.add(0);
        }

        /*
         * Agora começamos o Sliding Window.
         *
         * A cada passo:
         *
         * 1. adicionamos um novo caractere à direita;
         * 2. removemos o caractere mais antigo da esquerda;
         * 3. comparamos as frequências.
         */
        for (int right = p.length(); right < s.length(); right++) {

            // Adiciona o novo caractere que entrou pela direita.
            windowFrequency[s.charAt(right) - 'a']++;

            /*
             * Descobrimos qual caractere precisa sair da janela.
             *
             * Exemplo:
             *
             * p.length() = 3
             *
             * right = 3
             *
             * left = 3 - 3 = 0
             *
             * Portanto s[0] sai da janela.
             */
            int left = right - p.length();

            // Remove o caractere que saiu pela esquerda.
            windowFrequency[s.charAt(left) - 'a']--;

            /*
             * A nova janela começa em:
             *
             * left + 1
             */
            if (Arrays.equals(pFrequency, windowFrequency)) {
                result.add(left + 1);
            }
        }

        return result;
    }
}