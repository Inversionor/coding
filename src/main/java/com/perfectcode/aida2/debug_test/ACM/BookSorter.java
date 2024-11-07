package com.perfectcode.aida2.debug_test.ACM;

import java.util.*;

public class BookSorter {
    //main是静态方法，不能访问非静态内部类
    private  static class Book {
        private String name;
        private int price;

        public Book(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取书的数量
        int n = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        // 创建一个列表来存储书籍信息
        List<Book> books = new ArrayList<>();

        // 读取每本书的信息并添加到列表中
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            if (parts.length != 2) {
                System.out.println("输入格式错误，请确保每行包含一个书名和一个价格，中间用空格分隔。");
                return;
            }

            String name = parts[0];
            int price;
            try {
                price = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("价格必须是一个整数。");
                return;
            }

            books.add(new Book(name, price));
        }

        // 按照价格升序排序
        Collections.sort(books, Comparator.comparingInt(Book::getPrice));

        // 输出排序后的书名
        for (Book book : books) {
            System.out.println(book.getName());
        }
    }
}


