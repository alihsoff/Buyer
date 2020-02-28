/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buyer.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_goods")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TGoods implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "G_CODE")
    private int gCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "G_NAME")
    private String gName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "G_QTY")
    private int gQty;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "G_ID")
    private Integer gId;

    public int getGCode() {
        return gCode;
    }

    public void setGCode(int gCode) {
        this.gCode = gCode;
    }

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public int getGQty() {
        return gQty;
    }

    public void setGQty(int gQty) {
        this.gQty = gQty;
    }
}
