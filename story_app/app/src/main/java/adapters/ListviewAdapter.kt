import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.story_app.R
import model.StoryClass

class ListviewAdapter(
    private val context: Context,
    private val storyClassArrayList: ArrayList<StoryClass>
) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int = storyClassArrayList.size

    override fun getItem(position: Int): StoryClass = storyClassArrayList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.list_item, parent, false)
            viewHolder = ViewHolder(
                profile = view.findViewById(R.id.image),
                title = view.findViewById(R.id.title),
                time = view.findViewById(R.id.time),
                comment = view.findViewById(R.id.comment)
            )
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val story = getItem(position)
        with(viewHolder) {
            title.text = story.title
            time.text = story.time
            comment.text = story.comment
            profile.setImageResource(story.profile)
        }

        return view
    }

    private data class ViewHolder(
        val profile: ImageView,
        val title: TextView,
        val time: TextView,
        val comment: TextView
    )
}