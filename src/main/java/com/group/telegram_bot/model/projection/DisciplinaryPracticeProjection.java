package com.group.telegram_bot.model.projection;

public interface DisciplinaryPracticeProjection {
    String getPromotionType();

    String getCollectionType();

    void setPromotionType(String promotionType);

    void setCollectionType(String collectionType);
}
