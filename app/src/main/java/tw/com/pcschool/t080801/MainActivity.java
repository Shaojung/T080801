package tw.com.pcschool.t080801;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CopyDatabase();

    }

    private void CopyDatabase()
    {
        final int BUFFER_SIZE = 400000;
        final String DB_NAME = "test1.db"; // 保存的資料庫檔案名
        String PACKAGE_NAME = getPackageName();
        File DB_PATH = getDatabasePath(DB_NAME);
        Log.d("DB", DB_PATH.toString());
    }
}
