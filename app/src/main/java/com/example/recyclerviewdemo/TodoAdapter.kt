package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

//アダプターとなるクラスにRecyclerView.Adapter<クラス名.ビューホルダ名>()を継承
//引数にデータセットを持つ
class TodoAdapter(
    var todos: List<Todo>
    ) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    //ビューホルダを生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        //レイアウトインフレータを取得しR.layout.item_todoをインフレート
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        //ビューホルダオブジェクトにを生成する
        return TodoViewHolder(view)
    }

    //ビューホルダにデータをつける、第1引数にholder(textviewとcheckbutton)第2引数にインデックス
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        //ホルダーにタイトル名とチェックボックスを格納
        holder.itemView.apply {
            tvTitle.text = todos[position].title
            cbDone.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}