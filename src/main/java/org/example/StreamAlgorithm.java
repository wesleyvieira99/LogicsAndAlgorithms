package org.example;

import java.math.BigDecimal;
import java.util.List;

public class StreamAlgorithm {

    record Transaction(Long id, String customer, String category, BigDecimal amount, Status status) {}
    enum Status {APPROVED, PENDING, REJECTED}

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction(1L, "Wesley", "Tech", new BigDecimal("1500.00"), Status.REJECTED),
                new Transaction(2L, "Vinicius","Books", new BigDecimal("2000.40"), Status.APPROVED)
        );

        //1 - Buscar transacoes aprovadas
        List<Transaction> aprovadas = transactions.stream().filter(transaction -> transaction.status == Status.APPROVED).toList();

        //2 - Retornar somente os nomes dos clientes sem duplicados e em ordem alfabética
        List<String> customers = transactions.stream().map(Transaction::customer).distinct().sorted().toList();

        System.out.println(aprovadas);
        System.out.println(customers);
    }
}
