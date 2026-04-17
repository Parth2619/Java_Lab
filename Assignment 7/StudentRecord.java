import java.io.*;
import java.util.*;

public class StudentRecord {
    static final String FILE_NAME = "Students.csv";
    static Scanner sc = new Scanner(System.in);

    // ── Add student ────────────────────────────────────────────────────────────
    static void addRecord() {
        try {
            System.out.print("  Student ID : "); int studentId = Integer.parseInt(sc.nextLine().trim());
            System.out.print("  Name       : "); String name = sc.nextLine().trim();
            System.out.print("  Branch     : "); String branch = sc.nextLine().trim();
            System.out.print("  Marks 1    : "); double marks1 = Double.parseDouble(sc.nextLine().trim());
            System.out.print("  Marks 2    : "); double marks2 = Double.parseDouble(sc.nextLine().trim());
            System.out.print("  Marks 3    : "); double marks3 = Double.parseDouble(sc.nextLine().trim());

            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
            bw.write(studentId + "," + name + "," + branch + "," + marks1 + "," + marks2 + "," + marks3 + ",0,0,0");
            bw.newLine();
            bw.close();
            System.out.println("  ✓ Record added successfully.\n");
        } catch (NumberFormatException e) {
            System.out.println("  [ERROR] Invalid input: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("  [ERROR] File operation failed: " + e.getMessage());
        }
    }

    // ── View all records ───────────────────────────────────────────────────────
    static void viewRecords() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n  +-----+----------+----------+--------+--------+--------+--------+--------+-----------+");
            System.out.println("  | ID  | Name     | Branch   | Marks1 | Marks2 | Marks3 | Marks4 | Marks5 | Percent   |");
            System.out.println("  +-----+----------+----------+--------+--------+--------+--------+--------+-----------+");
            boolean any = false;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("studentId")) continue; // Skip header
                String[] parts = line.split(",");
                if (parts.length == 9) {
                    System.out.printf("  | %-3s | %-8s | %-8s | %-6s | %-6s | %-6s | %-6s | %-6s | %-9s |%n",
                            parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);
                    any = true;
                }
            }
            if (!any) System.out.println("  No records found.");
            System.out.println("  +-----+----------+----------+--------+--------+--------+--------+--------+-----------+\n");
        } catch (FileNotFoundException e) {
            System.out.println("  [ERROR] File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("  [ERROR] File operation failed: " + e.getMessage());
        }
    }

    // ── Update student record ─────────────────────────────────────────────────
    static void updateRecord(int studentId) {
        try {
            File file = new File(FILE_NAME);
            List<String> lines = new ArrayList<>();
            boolean found = false;
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String header = br.readLine(); // Read header
            lines.add(header);
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length == 9 && Integer.parseInt(p[0]) == studentId) {
                    System.out.print("  New Name   : "); String name   = sc.nextLine().trim();
                    System.out.print("  New Branch : "); String branch = sc.nextLine().trim();
                    System.out.print("  New Marks1 : "); double marks1 = Double.parseDouble(sc.nextLine().trim());
                    System.out.print("  New Marks2 : "); double marks2 = Double.parseDouble(sc.nextLine().trim());
                    System.out.print("  New Marks3 : "); double marks3 = Double.parseDouble(sc.nextLine().trim());
                    System.out.print("  New Marks4 : "); double marks4 = Double.parseDouble(sc.nextLine().trim());
                    System.out.print("  New Marks5 : "); double marks5 = Double.parseDouble(sc.nextLine().trim());
                    double percentage = calculatePercentage(marks1, marks2, marks3, marks4, marks5);
                    lines.add(studentId + "," + name + "," + branch + "," + marks1 + "," + marks2 + "," + marks3 + "," + marks4 + "," + marks5 + "," + String.format("%.2f", percentage));
                    found = true;
                } else {
                    lines.add(line);
                }
            }
            br.close();
            if (found) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                for (String l : lines) { bw.write(l); bw.newLine(); }
                bw.close();
                System.out.println("  ✓ Record updated successfully.\n");
            } else {
                System.out.println("  [ERROR] Student ID " + studentId + " not found.\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("  [ERROR] File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("  [ERROR] File operation failed: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("  [ERROR] Invalid input: " + e.getMessage());
        }
    }

    // ── Delete student record ─────────────────────────────────────────────────
    static void deleteRecord(int studentId) {
        try {
            File file = new File(FILE_NAME);
            List<String> lines = new ArrayList<>();
            boolean found = false;
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String header = br.readLine(); // Read header
            lines.add(header);
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length == 9 && Integer.parseInt(p[0]) == studentId) { 
                    found = true; 
                }
                else lines.add(line);
            }
            br.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String l : lines) { bw.write(l); bw.newLine(); }
            bw.close();
            if (found) {
                System.out.println("  ✓ Record deleted successfully.\n");
            } else {
                System.out.println("  [ERROR] Student ID " + studentId + " not found.\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("  [ERROR] File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("  [ERROR] File operation failed: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("  [ERROR] Invalid input: " + e.getMessage());
        }
    }

    // ── Calculate percentage ──────────────────────────────────────────────────
    static double calculatePercentage(double m1, double m2, double m3, double m4, double m5) {
        return (m1 + m2 + m3 + m4 + m5) / 5.0;
    }

    // ── Update percentage for all students ──────────────────────────────────
    static void updatePercentageForAll() {
        try {
            File file = new File(FILE_NAME);
            List<String> lines = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String header = br.readLine(); // Read header
            lines.add(header);
            boolean updated = false;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length == 9) {
                    try {
                        double m1 = Double.parseDouble(p[3]);
                        double m2 = Double.parseDouble(p[4]);
                        double m3 = Double.parseDouble(p[5]);
                        double m4 = Double.parseDouble(p[6]);
                        double m5 = Double.parseDouble(p[7]);
                        double percentage = calculatePercentage(m1, m2, m3, m4, m5);
                        lines.add(p[0] + "," + p[1] + "," + p[2] + "," + p[3] + "," + p[4] + "," + p[5] + "," + p[6] + "," + p[7] + "," + String.format("%.2f", percentage));
                        updated = true;
                    } catch (NumberFormatException e) {
                        lines.add(line);
                    }
                } else {
                    lines.add(line);
                }
            }
            br.close();
            if (updated) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                for (String l : lines) { bw.write(l); bw.newLine(); }
                bw.close();
                System.out.println("  ✓ Percentages updated for all students.\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("  [ERROR] File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("  [ERROR] File operation failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     Student Record Management        ║");
        System.out.println("╚══════════════════════════════════════╝\n");
        while (true) {
            System.out.println("  1. Add Student       2. View All      3. Update Record");
            System.out.println("  4. Update Percentage 5. Delete Record  0. Exit");
            System.out.print("  Choice: ");
            int ch;
            try { ch = Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { 
                System.out.println("  [ERROR] Invalid input: " + e.getMessage() + "\n"); 
                continue; 
            }
            switch (ch) {
                case 1: 
                    System.out.println("\n--- ADD STUDENT ---");
                    addRecord(); 
                    break;
                case 2: 
                    System.out.println("\n--- VIEW ALL RECORDS ---");
                    viewRecords(); 
                    break;
                case 3:
                    System.out.println("\n--- UPDATE RECORD ---");
                    System.out.print("  Student ID to update: ");
                    try { 
                        updateRecord(Integer.parseInt(sc.nextLine().trim())); 
                    }
                    catch (NumberFormatException e) { 
                        System.out.println("  [ERROR] Invalid input: " + e.getMessage() + "\n"); 
                    }
                    break;
                case 4:
                    System.out.println("\n--- UPDATE PERCENTAGE ---");
                    updatePercentageForAll();
                    break;
                case 5:
                    System.out.println("\n--- DELETE RECORD ---");
                    System.out.print("  Student ID to delete: ");
                    try { 
                        deleteRecord(Integer.parseInt(sc.nextLine().trim())); 
                    }
                    catch (NumberFormatException e) { 
                        System.out.println("  [ERROR] Invalid input: " + e.getMessage() + "\n"); 
                    }
                    break;
                case 0: 
                    System.out.println("\n  Goodbye!\n"); 
                    sc.close(); 
                    return;
                default: 
                    System.out.println("  [ERROR] Invalid option. Please try again.\n");
            }
        }
    }
}