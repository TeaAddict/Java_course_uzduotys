public class InvoiceItem {
    String id;
    String desc;
    int qty;
    double unitPrice;

    public InvoiceItem(String id, String desc, int qty, double unitPrice) {
        this.id = id;
        this.desc = desc;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getID() {
        return this.id;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getQty() {
        return this.desc;
    }

    public String setQty() {
        return this.desc;
    }

    public String getUnitPrice() {
        return this.desc;
    }

    public String setUnitPrice() {
        return this.desc;
    }

    public String getTotal() {
        return this.desc;
    }

    public String toString() {
        return "InvoiceItem[id=" + this.id + ",desc=" + this.desc + ",qty=" + this.qty + ",unitPrice=" + this.unitPrice + "]";
    }


}

