package me.shawn.polar.platform.code;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Alias("code")
public class Code {

    private Long id;
    private String groupKey;
    private String codeKey;
    private String codeValue;
    private Long sequence;
    private String description;
    private String[] filters;
    private boolean selectable;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Code() {
    }

    public Code(Long id, String groupKey, String codeKey, String codeValue, Long sequence, String description, String[] filters) {
        this.id = id;
        this.groupKey = groupKey;
        this.codeKey = codeKey;
        this.codeValue = codeValue;
        this.sequence = sequence;
        this.description = description;
        this.filters = filters;
        this.selectable = true;
        this.deleted = false;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }
    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getCodeKey() {
        return codeKey;
    }

    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getFilters() {
        return filters;
    }

    public void setFilters(String[] filters) {
        this.filters = filters;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
