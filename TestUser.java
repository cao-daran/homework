package lab_2_2.webWork.Notebook.src.main.java.Notebook;

import java.util.Scanner;

public class TestUser {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        System.out.println("创建记事本\n" +
                "下面选择你想要的的操作");
        System.out.println("添加为1，删除为2，检索为3，展示为4，标记完成为5");
        Scanner scanner = new Scanner(System.in);
        String line;
        System.out.println("如果想结束，请输入end以结束程序");
        System.out.println("排序编号是从0开始，例如0,1,2,3……");
        while (!"end".equals(line = scanner.nextLine())) {
            if (line.equals("1")) {
                System.out.println("请输入追加的信息");
                notebook.addition(scanner.nextLine());
            }

            if (line.equals("2")) {
                System.out.println("删除指定一条为1，删除全部为2");
                switch (scanner.nextLine()) {
                    case "1":
                        System.out.println("删除指定位置，请输入编号");
                        notebook.deleteSingle(scanner.nextInt());
                        break;
                    case "2":
                        notebook.deleteAll();
                        break;
                }
            }

            if (line.equals("3")) {
                System.out.println("请输入你想要检索的名字");
                notebook.search(scanner.nextLine());
            }

            if (line.equals("4")) {
                System.out.println("展示其中一个为1，展示全部为2");
                switch (scanner.nextLine()) {
                    case "1":
                        System.out.println("请输入展示序号");
                        notebook.showSingle(scanner.nextLine());
                        System.out.println("排序编号是从0开始，例如0,1,2,3……");
                        break;
                    case "2":
                        notebook.showAll();
                        System.out.println("排序编号是从0开始，例如0,1,2,3……");
                        break;
                }
            }
            if (line.equals("5")) {
                System.out.println("请输入您想要完成的任务编号");
                notebook.accomplish(scanner.nextInt());
            }
            System.out.println("添加为1，删除为2，检索为3，展示为4,完成任务为5");
        }
    }
}
