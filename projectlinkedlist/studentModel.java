package projectlinkedlist;

public class studentModel {
    private int id;
    private String Name;
    private String Address;
    private String Kelas;

    public studentModel(int id, String Name, String Kelas, String Address) {
        this.id = id;
        this.Name = Name;
        this.Address = Address;
        this.Kelas = Kelas;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getKelas() {
        return Kelas;
    }

    public void setKelas(String Kelas) {
        this.Kelas = Kelas;
    }
}
