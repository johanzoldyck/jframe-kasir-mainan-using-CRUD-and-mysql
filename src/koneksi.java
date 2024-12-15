
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.Statement;
    import javax.swing.JOptionPane;

    public class koneksi {
        Connection con;
        Statement stm;

        // Method untuk mengonfigurasi koneksi database
        public void config() {
            try {
                // Menggunakan nama database yang sesuai
                String url = "jdbc:mysql://localhost:3306/db_kasir"; 
                String user = "root";
                String pass = "";

                con = DriverManager.getConnection(url, user, pass);
                stm = con.createStatement();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage());
            }
        }

        // Main method untuk menjalankan program
        public static void main(String[] args) {
            koneksi db = new koneksi(); // Membuat instance dari kelas koneksi
            db.config(); // Menguji koneksi dengan memanggil config()
        }
    }
