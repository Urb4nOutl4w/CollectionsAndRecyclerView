package at.fh.swengb.collectionsandrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    val studentsList = listOf<Student>(Student("Rob", 27), Student("George", 27), Student("Lisa", 25), Student("Tim",3), Student("Simone",3))
    val mutableStudentsList = mutableListOf<Student>(Student("Rob", 27), Student("George", 27), Student("Lisa", 25), Student("Tim",3), Student("Simone",3))
    val studentsSet = setOf<Student>(Student("Rob", 27), Student("Rob", 27), Student("Lisa", 25), Student("Tim",3), Student("Simone",3))
    val mutableStudentsSet = mutableSetOf<Student>(Student("Rob", 27), Student("Rob", 27), Student("Lisa", 25), Student("Tim",3), Student("Simone",3))

    val ima18List = listOf(Student("Tyrion", 1), Student("Jon", 1))
    val ima17List = mutableListOf(Student("Sansa", 3), Student("Arya", 3), Student("Bran", 3))
    val studentMap = mapOf<String, List<Student>>("IMA18" to ima18List, "IMA17" to ima17List)
    val mutableStudentMap = studentMap.toMutableMap()
    val ima16List = listOf(Student("peter",4), Student("david",5))



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("Tag",studentsList[2].name)
        mutableStudentsList.set(3, Student("test", 42))
        Log.e("tag", mutableStudentsList[3].name)
        mutableStudentsList.add(Student("newStudent",24))
        for(student in mutableStudentsList){
            Log.e("tag",student.name)
        }
        for(student in studentsSet){
            Log.i("TAG", student.name)
        }
        mutableStudentsSet.add(Student("Rob",27))
        mutableStudentsSet.add(Student("Hello",24))

        for(student in mutableStudentsSet){
            Log.e("tag","Student ${student.name} is in the ${student.currentSemester} [st, nd, rd, th] semester")
        }
        for(student in mutableStudentsSet){
            if (student.name == "Rob") {
                Log.i("tag", "Student ${student.name} is in the ${student.currentSemester} [st, nd, rd, th] semester")
            }
        }

        for ((studie, students) in studentMap){
            for(student in students){
                Log.e("tag", "student: ${student.name}, studie: $studie, semester: ${student.currentSemester}")
            }
        }
        ima17List.add(Student("tim", 3))
        for ((studie, students) in studentMap){
            for(student in students){
                Log.i("tag", "student: ${student.name}, studie: $studie, semester: ${student.currentSemester}")
            }
        }

        mutableStudentMap["ima16"] = ima16List


        for ((studie, students) in mutableStudentMap){
            for(student in students){
                Log.i("tag", "student: ${student.name}, studie: $studie, semester: ${student.currentSemester}")
            }
        }

    }
}
