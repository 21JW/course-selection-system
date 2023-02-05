package com.singfung.demo.service;

import com.singfung.demo.model.entity.IWithPosition;

import java.util.ArrayList;
import java.util.List;

public class AppUtills {
    public static <T extends IWithPosition> List<T> setPositionInList(T t, List<T> list, Integer position) {
        if (t.getPosition().equals(position)) return list;

        int step;
        int startPosition;
        int endPosition;
        int id = t.getId();

        // 新位置 > 当前位置（从上往下移动）
        if (position > t.getPosition()) {
            startPosition = t.getPosition();
            endPosition = position;
            step = -1;
        } else {
            startPosition = position;
            endPosition = t.getPosition();
            step = 1;
        }

        List<T> changedList = new ArrayList<>();
        for (T item : list) {
            // 在交换列表[之前] or [之后] 的数据不动
            if (item.getPosition() < startPosition || item.getPosition() > endPosition) continue;
            // 将当前需要改变的item，设置为新的位置
            if (item.getId() == id) {
                item.setPosition(position);
            } else {
                // 其他位置相应 +1 / -1
                item.setPosition(item.getPosition() + step);
            }
            // 整合进新的list
            changedList.add(item);
        }
        return changedList;
    }
}
