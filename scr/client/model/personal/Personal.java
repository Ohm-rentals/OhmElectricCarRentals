package client.model.personal;


import client.model.personal.status.Offline;
import client.model.personal.status.Online;
import client.model.personal.status.Stat;
import client.model.personal.status.Status;
import shared.transferObjects.user.User;
import shared.transferObjects.user.UserKind;


public class Personal {

    static Personal personal;
    User identity;
    Status status;

    private Personal(){
        status = new Offline();
    }


    public User getIdentity() {
        return identity;
    }

    public Stat getStatus() {
        return status.getStatus();
    }

    public void setOffline() {
        status = new Offline();
        identity = null;
    }

    public void setOnline() {
        status = new Online();
    }

    public void logOut() {
        status.logOut(this);
    }

    public void logIn() {
        status.logIn(this);
    }

    public void setIdentity(User identity) {
        this.identity = identity;
        if (identity != null)
            setOnline();
    }

    public UserKind getKind(){
        return this.identity.getKind();
    }

    public static Personal getPersonal() {
        if (personal == null) {
            personal = new Personal();
        }
        return personal;
    }



    /*
    private void setMenuBar() {
        Personal personal = Personal.getPersonal();
        System.out.println("the status is:" + personal.getStatus());
        logInText.setText(personal.getStatus().equals(Stat.ONLINE) ? "Settings" : "Login");
    }

     */
}
