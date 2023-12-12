package se.model.apiModel.responseModel;

import java.util.List;

public class BrowseCategoryModel {

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private List<Categories> categories;
    private int limit;
    private String next;
    private int offset;
    private Object previous;            //An unknown data type
    private int total;
    private class Categories {
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public List<Items> getItems() {
            return items;
        }

        public void setItems(List<Items> items) {
            this.items = items;
        }

        private List<Items> items;

        private class Items {
            private String href;
            private List<Icons> icons;
            private String id;

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public List<Icons> getIcons() {
                return icons;
            }

            public void setIcons(List<Icons> icons) {
                this.icons = icons;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            private String name;
            private class Icons {
                private int height;
                private String url;
                private int width;

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }
            }
        }
    }
}
