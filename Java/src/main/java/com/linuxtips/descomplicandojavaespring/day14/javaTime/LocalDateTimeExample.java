package com.linuxtips.descomplicandojavaespring.day14.javaTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample {

    public static void main(String[] args) {

        LocalDate dataDeHoje = LocalDate.now();
        System.out.println("Data de hoje: " + dataDeHoje);

        LocalDate dataDeOntem = dataDeHoje.minusDays(1);
        System.out.println("Data de ontem: " + dataDeOntem);

        LocalDate hojeMaisDois = dataDeHoje.plusDays(2);
        System.out.println("Hoje mais dois dias: " + hojeMaisDois);

        LocalDate dataTransformada = LocalDate.of(2024, 12, 25);
        System.out.println("Data transformada: " + dataTransformada);

        LocalDateTime horaTransformada = dataTransformada.atTime(22, 20, 19);
        System.out.println("Hora transformada: " + horaTransformada);

        LocalTime queHorasSao = LocalTime.now();
        System.out.println("Que horas são: " + queHorasSao);

        LocalTime horaTransformada2 = LocalTime.of(22, 20, 19);
        LocalTime adicionandoHoras = horaTransformada2.plusHours(8);
        System.out.println("Adicionando horas: " + adicionandoHoras);

        LocalTime adicionandoMinutos = adicionandoHoras.plusMinutes(8);
        System.out.println("Adicionando minutos: " + adicionandoMinutos);

        YearMonth anoMes = YearMonth.now();
        System.out.println("Ano e mês: " + anoMes);

        String anoMesFormatado = anoMes.format(DateTimeFormatter.ofPattern("MM/yy"));
        System.out.println("Ano e mês formatado: " + anoMesFormatado);

    }

}
