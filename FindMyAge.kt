//import java.time.YearMonth
import java.util.*
import java.util.Calendar



fun main() {
//    var days = YearMonth.of(2000,2)
//    println(days.lengthOfMonth())
    var yobstr = "22/02/2000"
    var calendar_month = arrayOf(31,28,31,30,31,30,31,31,30,31,30,31)
    var yobarr = yobstr.split("/")
    var date = yobarr[0].toInt()
    var month = yobarr[1].toInt()
    var year = yobarr[2].toInt()
    var c_date = Calendar.getInstance().get(Calendar.DATE)
    var c_month = Calendar.getInstance().get(Calendar.MONTH) + 1
    var c_year = Calendar.getInstance().get(Calendar.YEAR)
    if (c_date < date){
        if (month == 2){
            if (leap_year(year)){
                c_date = 29 + c_date - date
            }
            else{
                c_date = 28 + c_date - date
            }
        }
        else {
            c_date = calendar_month[month-1] + c_date - date
        }

        month++
    }
    else{
        c_date -=  date
    }
    if (c_month < month){
        c_month = 12 + c_month - month
        year++
    }
    else {
        c_month -= month
    }
    c_year -= year
    println("You have lived for $c_year years $c_month months $c_date days!")
}
fun leap_year(year: Int): Boolean{
    return if (year % 4 == 0){
        if (year % 100 == 0) {
            year % 400 == 0
        }
        else true
    }
    else false
}