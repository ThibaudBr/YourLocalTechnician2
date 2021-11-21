package org.architecturelogiciel.core.requests;

public class UpdateInvoiceStatusRequest {

    private int id;
    private boolean status;

    public UpdateInvoiceStatusRequest(int id, boolean status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public boolean getStatus() {
        return status;
    }
}
