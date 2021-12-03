package client.views;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.stage.Stage;

public interface ViewController {
  void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory);
 // void reset();
}
