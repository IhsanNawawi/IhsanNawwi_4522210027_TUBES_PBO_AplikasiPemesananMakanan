// SecondaryController.java
package tubes_pbo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondaryController {
    @FXML
    private Label receiptLabel;

    private Date tanggal;

    public void initData(double totalAmount, double amountPaid, String namaPelanggan, String nomorMeja) {
        double change = amountPaid - totalAmount;

        // Set tanggal dengan waktu saat ini
        tanggal = new Date();

        // Format tanggal menggunakan SimpleDateFormat jika diperlukan
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = formatter.format(tanggal);

        receiptLabel.setText("NAMA PELANGGAN : " + namaPelanggan +
                "\nNOMOR MEJA : " + nomorMeja +
                "\nTOTAL : Rp " + totalAmount +
                "\nBAYAR : Rp " + amountPaid +
                "\nKEMBALI: Rp " + change +
                "\nTANGGAL : " + formattedDate);
    }

    public Date getTanggal() {
        return tanggal;
    }
}
