public class User {
    private String username;
    private String password;
    // Constructors, getters, setters
}

public class Expense {
    private String category;
    private double amount;
    private LocalDate date;
    private String description;
    // Constructors, getters, setters
}
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, String> users = new HashMap<>();

    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, password);
        return true;
    }

    public boolean login(String username, String password) {
        return users.getOrDefault(username, "").equals(password);
    }
}
import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void editExpense(int index, Expense expense) {
        expenses.set(index, expense);
    }

    public void deleteExpense(int index) {
        expenses.remove(index);
    }

    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }
}
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportService {
    private ExpenseService expenseService;

    public ReportService(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public Map<String, Double> getExpenseSummary() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return expenses.stream()
                .collect(Collectors.groupingBy(Expense::getCategory, Collectors.summingDouble(Expense::getAmount)));
    }
}
import java.util.Scanner;

public class ExpenseTrackerApp {
    private static UserService userService = new UserService();
    private static ExpenseService expenseService = new ExpenseService();
    private static ReportService reportService = new ReportService(expenseService);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Implement the main loop for user interaction
    }

    private static void displayMenu() {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Add Expense");
        System.out.println("4. Edit Expense");
        System.out.println("5. Delete Expense");
        System.out.println("6. View Report");
        System.out.println("7. Exit");
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (userService.register(username, password)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Username already exists.");
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (userService.login(username, password)) {
            System.out.println("Login successful!");
            userMenu();
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void userMenu() {
        // Implement the user menu for adding, editing, and viewing expenses
    }
}
