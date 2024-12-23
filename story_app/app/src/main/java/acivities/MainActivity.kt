package activities

import adapters.ListviewAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.story_app.R
import model.StoryClass

class MainActivity : AppCompatActivity() {
    private val titles = arrayOf(
        "AI Expert",
        "Soft Skills Trainer",
        "Web Designer",
        "CEO",
        "Doctor"
    )

    private val profiles = intArrayOf(
        R.drawable.Untitled,
        R.drawable.Untitled2,
        R.drawable.Untitled3,
        R.drawable.Untitled4,
        R.drawable.Untitled5
    )

    private val times = arrayOf(
        "25 min ago",
        "15 min ago",
        "12 min ago",
        "3 min ago",
        "2 min ago"
    )

    private val comments = arrayOf(
        "Congrats!",
        "Congrats!",
        "Congrats!",
        "Congrats!",
        "Congrats!"
    )

    private lateinit var storyClassList: ArrayList<StoryClass>
    private lateinit var listViewAdapter: ListviewAdapter
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.story_app)

        listView = findViewById(R.id.list)

        val headerView = layoutInflater.inflate(R.layout.header, null, false)
        listView.addHeaderView(headerView)

        storyClassList = ArrayList()

        for (i in titles.indices) {
            val story = StoryClass(titles[i], profiles[i], times[i], comments[i])
            storyClassList.add(story)
        }

        listViewAdapter = ListviewAdapter(this, storyClassList)
        listView.adapter = listViewAdapter
    }
}
