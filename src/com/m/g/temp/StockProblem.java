package com.m.g.temp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StockProblem {

    Map<String, Problem> tickCount = new ConcurrentHashMap<>();


    public void put(String symbol, double price) {
        Problem problem = null;
        if (tickCount.containsKey(symbol)) {
            problem = tickCount.get(symbol);
            problem.setCount(problem.getCount()+1);
            problem.setStock(problem.getStock()+price);
        } else {
            problem = new Problem();
            problem.setCount(1);
            problem.setStock(price);

        }
        tickCount.put(symbol, problem);
    }

    public double getAveragePrice(String symbol) {
        double returnValue = 0.0;
        Problem p = tickCount.get(symbol);
        if (p != null) {
            returnValue = (p.getStock()/p.getCount());
        }

        return returnValue;
    }

    public int tickCount(String symbol) {
        int returnValue = 0;

        if (symbol != null) {
            Problem problem = tickCount.get(symbol);
            if (problem != null) {
                returnValue = problem.count;
            }

        }

        return returnValue;
    }

    public static void main(String[] args) {

        StockProblem stockProblem = new StockProblem();

        stockProblem.put("IBM",22.22);
                stockProblem.put("AAPL",33.33);
        stockProblem.put("IBM",44.44);
        stockProblem.put("AAPL",55.55);
        stockProblem.put("IBM",66.66);

       int tick =  stockProblem.tickCount("IBM");

       double avg = stockProblem.getAveragePrice("IBM");


       System.out.println(" IBM Tick "+tick+" Avg "+avg);

        int tick1 =  stockProblem.tickCount("AAPL");

        double avg1 = stockProblem.getAveragePrice("AAPL");

        System.out.println(" AAPL Tick "+tick+" Avg "+avg);

    }


    static class Problem {
        double stock = 0.0;
        int count = 0;

        public double getStock() {
            return stock;
        }

        public void setStock(double stock) {
            this.stock = stock;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
