package client.core;

import client.views.catalogView.CatalogViewModel;
import client.views.createAccountView.CreateAccountViewModel;
import client.views.createCarView.CreateCarViewModel;
import client.views.loginView.LoginViewModel;
import client.views.manageAccountView.ManageAccountsViewModel;
import client.views.manageCarsView.ManageCarsViewModel;
import client.views.myAccountView.MyAccountViewModel;
import client.views.searchView.SearchViewModel;

public class ViewModelFactory {
    private ModelFactory modelFactory;

    private CatalogViewModel catalogViewModel;
    private CreateAccountViewModel createAccountViewModel;
    private CreateCarViewModel createCarViewModel;
    private LoginViewModel loginViewModel;
    private ManageAccountsViewModel manageAccountsViewModel;
    private ManageCarsViewModel manageCarsViewModel;
    private SearchViewModel searchViewModel;
    private MyAccountViewModel myAccountViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public CatalogViewModel getCatalogViewModel() {
        if (catalogViewModel == null)
        return new CatalogViewModel();
        return catalogViewModel;
    }

    public CreateAccountViewModel getCreateAccountViewModel() {
        if (createAccountViewModel == null)
        return new CreateAccountViewModel();
        return createAccountViewModel;
    }

    public CreateCarViewModel getCreateCarViewModel() {
        if (createCarViewModel == null)
            return new CreateCarViewModel();
        return createCarViewModel;
    }

    public LoginViewModel getLoginViewModel() {
        if (loginViewModel == null)
            return new LoginViewModel(modelFactory.getUsersModel());
        return loginViewModel;
    }

    public ManageAccountsViewModel getManageAccountsViewModel() {
        if (manageAccountsViewModel == null)
            return new ManageAccountsViewModel();
        return manageAccountsViewModel;
    }

    public ManageCarsViewModel getManageCarsViewModel() {
        if (manageCarsViewModel == null)
            return new ManageCarsViewModel();
        return manageCarsViewModel;
    }

    public SearchViewModel getSearchViewModel() {
        if (searchViewModel == null)
            return new SearchViewModel();
        return searchViewModel;
    }

    public MyAccountViewModel getMyAccountViewModel() {
        if (searchViewModel == null)
            return new MyAccountViewModel();
        return myAccountViewModel;
    }


}
