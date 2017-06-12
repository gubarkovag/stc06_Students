package stc06.gubarkov.daos;

import stc06.gubarkov.models.ParentModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManageSingleEntity<T extends ParentModel> {
    private Map<Long, T> members = new HashMap<>();

    public void create(T member) {
        members.put(member.getId(), member);
    }

    public void delete(T member) {
        members.remove(member.getId());
    }

    public void update(T member) {
        members.put(member.getId(), member);
    }

    public T findMemberById(T member) {
        return members.get(member.getId());
    }

    public Collection<T> findAllMembers() {
        return members.values();
    }
}
