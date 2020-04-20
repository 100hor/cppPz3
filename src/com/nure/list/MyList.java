package com.nure.list;

import com.nure.model.Phone;

public interface MyList extends Iterable<Phone>{
    void add(Phone phone);
    void clear();
    boolean remove(Phone phone);
    Object[] toArray();
    int size();
    boolean contains(Phone phone);

}
