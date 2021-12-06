package client.views.searchView;


import java.time.LocalDate;

public class SearchViewModel {

    public SearchViewModel() {
    }

    public void onSearch(String selectedItem, String item, LocalDate dateFrom, LocalDate dateTo) {

        System.out.println(selectedItem);
        System.out.println(item);
        System.out.println(dateFrom);
        System.out.println(dateTo);
    }

}
