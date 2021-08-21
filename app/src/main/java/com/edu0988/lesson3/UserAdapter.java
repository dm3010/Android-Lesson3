package com.edu0988.lesson3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс адаптера,
 * обеспечивает привязку коллекции {@link List} к Views, предоставленные {@link UserHolder},
 * которые отображаются списком с помощью {@link RecyclerView}
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private List<String> users;

    /**
     * Конструктор адаптера, инициализация коллекции
     *
     * @param users Коллекция {@link List} с содержимым типа {@link String}
     */
    public UserAdapter(ArrayList<String> users) {
        this.users = users;
    }

    /**
     * Создание нового {@link UserHolder}, для дальнейшего отображения (вызывается LayoutManager)
     *
     * @param parent   ViewGroup, в которую будет добавлен созданный View, когда потребуется
     * @param viewType тип нового View
     * @return созданный {@link UserHolder}
     */
    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Получаем наполнитель из контекста родительского View (parent)
        // в нашем случае RecycleView
        View v = LayoutInflater.from(parent.getContext())
                //Создаем пустой View с шаблоном R.layout.single_item и "наполняем" в родителя
                .inflate(R.layout.single_item, parent, false);
        // Создание Holder для этого View
        return new UserHolder(v);
    }

    /**
     * Отображение/перезапись содержимого View (вызывается LayoutManager)
     *
     * @param holder   ViewHolder, созданный ранее
     * @param position позиция элемента в коллекции
     */
    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserHolder holder, int position) {
        String user = users.get(position);
        // Команда Holder'у на установку текстового значения
        holder.bind(user);
    }

    /**
     * @return количество элементов в коллекции
     */
    @Override
    public int getItemCount() {
        return users.size();
    }

    /**
     * Предоставляет ссылку для адаптера на отдельную View на экране в списке
     * количество Holder != количеству элементов списка
     * при списке 100 шт, и одновременном отображении 14 количество ViewHolder
     * созданных при скроллинге не превысило 19
     */
    public static class UserHolder extends RecyclerView.ViewHolder {

        // Элемент TextView в текущей View (single_item)
        private final TextView itemTextView;

        // Конструктор и инициализация Holder'а
        public UserHolder(@NonNull View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.itemTextView);
        }

        /**
         * Запись текста в TextView
         *
         * @param userName имя пользователя для отображения
         */
        public void bind(String userName) {
            itemTextView.setText(userName);
        }
    }
}
