package com.internal.working;

import java.time.Month;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class LambdaImplementation {

    public static void main(String[] args) {
        List<Invoice> invoices = new LinkedList<>();
        invoices.add(new Invoice(1000, Month.JULY, "JUL-1"));
        invoices.add(new Invoice(3000, Month.JULY, "JUL-2"));
        invoices.add(new Invoice(4000, Month.JUNE, "JUN"));
        invoices.add(new Invoice(6000, Month.JULY, "JUL-3"));

        //using implicite method using invokedynamic
        int total1 = invoices.stream()
                .filter(inv -> inv.getMonth() == Month.JULY)
                .mapToInt(Invoice::getAmount)
                .sum();
        System.out.println(total1);

        //this will create other class for anonymously
        // 2 anonymous classes will create
        //1 for Predicate
        //2nd for ToIntFunction
        int total = invoices.stream()
                .filter(new Predicate<Invoice>() {
                    @Override
                    public boolean test(Invoice inv) {
                        return inv.getMonth() == Month.JULY;
                    }
                })
                .mapToInt(new ToIntFunction<Invoice>() {
                    @Override
                    public int applyAsInt(Invoice inv) {
                        return inv.getAmount();
                    }
                })
                .sum();
        System.out.println("total " + total);

        Function<String, Integer> f = s -> Integer.parseInt(s);
        
    }
}
class Invoice{

    private int amount;
    private Month month;
    private String name;

    public Invoice(int amount, Month month, String name) {
        this.amount = amount;
        this.month = month;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return amount == invoice.amount &&
                month == invoice.month &&
                Objects.equals(name, invoice.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, month, name);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }
}
