package shared.transferObjects.user;

import java.io.Serializable;

public enum UserKind implements Serializable {
    ADMIN,
    CUSTOMER,
    FRONT_DESK,
    GUEST
}
