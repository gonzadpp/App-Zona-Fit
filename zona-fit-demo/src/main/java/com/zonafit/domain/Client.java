package com.zonafit.domain;

public class Client {
    private int id_cliente;
    private String name;
    private String lastName;
    private int membership;

    public Client(){}

    public Client(int id_cliente){ //Constructor para eliminar un registro de tipo cliente
        this.id_cliente = id_cliente;
    }
    //Para insertar un nuevo registro de tipo cliente.
    public Client(String name, String lastName, int membership){ 
        this.name = name;
        this.lastName = lastName;
        this.membership = membership;
    }
    //Para recueperar los registros de tipo cliente.
    public Client(int id_cliente, String name, String lastName, int membership){
        this(name, lastName, membership); 
        this.id_cliente = id_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMembership() {
        return membership;
    }

    public void setMembership(int membership) {
        this.membership = membership;
    }

    @Override
    public String toString() {
        return "Cliente [id_cliente=" + id_cliente + ", name=" + name + ", lastName=" + lastName + ", membership="
                + membership + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_cliente;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + membership;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (id_cliente != other.id_cliente)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (membership != other.membership)
            return false;
        return true;
    }

    

}
