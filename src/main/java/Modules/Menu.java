package Modules;

import java.util.List;

public class Menu {
    private List<Category> categories;

    public Menu(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        return categories != null ? categories.equals(menu.categories) : menu.categories == null;
    }

    @Override
    public int hashCode() {
        return categories != null ? categories.hashCode() : 0;
    }

    @Override
    public String toString() {
        return categories.toString();
    }
}
