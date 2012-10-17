package org.multibit.store.views;

import org.multibit.mbm.model.PublicItem;

/**
 * <p>View to provide the following to resources:</p>
 * <ul>
 * <li>Representation of the public item detail page</li>
 * </ul>
 *
 * @since 0.0.1
 *
 */
public class PublicItemView extends PublicFreemarkerView {

  private final PublicItem item;

  public PublicItemView(String templateName, PublicItem item) {
    super(templateName);
    this.item=item;
  }

  public PublicItem getItem() {
    return item;
  }

}
