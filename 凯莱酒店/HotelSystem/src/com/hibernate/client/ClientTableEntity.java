package com.hibernate.client;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client_table", schema = "hotel_system", catalog = "")
public class ClientTableEntity {
    private String clientName;
    private long clientId;
    private String clientSex;
    private String clientOrderId;

    @Basic
    @Column(name = "client_name", nullable = true, length = 255)
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Id
    @Column(name = "client_id", nullable = false)
    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "client_sex", nullable = true, length = 255)
    public String getClientSex() {
        return clientSex;
    }

    public void setClientSex(String clientSex) {
        this.clientSex = clientSex;
    }

    @Basic
    @Column(name = "client_order_id", nullable = true, length = 255)
    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientTableEntity that = (ClientTableEntity) o;
        return clientId == that.clientId &&
                Objects.equals(clientName, that.clientName) &&
                Objects.equals(clientSex, that.clientSex) &&
                Objects.equals(clientOrderId, that.clientOrderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientName, clientId, clientSex, clientOrderId);
    }

    @Override
    public String toString() {
        return clientName + "..." + clientSex + "..." + clientId + "..." + clientOrderId ;
    }
}
