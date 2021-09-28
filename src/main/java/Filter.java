import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    private int filter;
    // конструктор
    public Filter(int num){
        this.filter = num;
    }
    // геттеры-сеттеры
    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }
    // фильтрация списка
    public List<Integer> filterOut(List<Integer> list){
        Logger logger = Logger.get();
        logger.add("Фильтрация списка filterOut(List<Integer> list)");
        return
        list.stream()
                .filter(x->x<filter)
                .collect(Collectors.toList());
    }
}
