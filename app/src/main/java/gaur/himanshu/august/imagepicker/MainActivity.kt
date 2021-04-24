package gaur.himanshu.august.imagepicker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker

class MainActivity : AppCompatActivity() {

    var imagePicker: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagePicker = findViewById(R.id.picker_image)

        val gallery = findViewById<Button>(R.id.gallery)
        val camera = findViewById<Button>(R.id.camera)

        gallery.setOnClickListener {

            ImagePicker.with(this).galleryOnly().galleryMimeTypes(arrayOf("image/*")).crop()
                .maxResultSize(400, 400).start()

        }

        camera.setOnClickListener {

            ImagePicker.with(this).cameraOnly().crop().maxResultSize(400, 400).start()

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode== Activity.RESULT_OK && requestCode== ImagePicker.REQUEST_CODE) {


            imagePicker?.setImageURI(data?.data)

        }

    }


}