import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

class AgeCalculator {


    @RequiresApi(Build.VERSION_CODES.O)


    companion object {
        fun calculAge(yearOfBirth: Int): Int {

            val currentYear = LocalDate.now().year

            return currentYear - yearOfBirth
        }
    }
}
