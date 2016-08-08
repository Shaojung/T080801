package tw.com.pcschool.t080801;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CopyDatabase();

    }

    private void CopyDatabase() {
        final int BUFFER_SIZE = 400000;
        final String DB_NAME = "test1.sqlite"; // 保存的資料庫檔案名
        String PACKAGE_NAME = getPackageName();
        File DB_PATH = getDatabasePath(DB_NAME);

        DB_PATH.mkdir();

        Log.d("DB", "DB:" + DB_PATH.toString());


        try {
            if (!(DB_PATH.exists())) {
                File DIR = new File(getApplicationInfo().dataDir + "/databases");

                DIR.mkdir();
                Log.d("DB", "DIR:" + DIR.toString());
                // 判斷資料庫檔案是否存在，若不存在則執行導入，否則直接打開資料庫
                InputStream is = getResources().openRawResource(R.raw.test1);
                FileOutputStream fos = new FileOutputStream(DB_PATH);
                byte[] buffer = new byte[BUFFER_SIZE];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.close();
                is.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}