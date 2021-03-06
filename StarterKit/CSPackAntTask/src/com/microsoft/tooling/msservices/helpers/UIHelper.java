/**
 * Copyright (c) Microsoft Corporation
 * <p/>
 * All rights reserved.
 * <p/>
 * MIT License
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.microsoft.tooling.msservices.helpers;

import com.microsoft.tooling.msservices.model.storage.*;
import com.microsoft.tooling.msservices.model.ws.WebSite;
import com.microsoft.tooling.msservices.model.ws.WebSiteConfiguration;

import java.io.File;
import java.util.Map;

public interface UIHelper {
    void showException(@NotNull String message,
                       Throwable ex,
                       @NotNull String title,
                       boolean appendEx,
                       boolean suggestDetail);

    void showError(@NotNull String message, @NotNull String title);

    boolean showConfirmation(@NotNull String message, @NotNull String title, @NotNull String[] options, String defaultOption);

    void logError(String message, Throwable ex);

    File showFileChooser(String title);

    <T extends StorageServiceTreeItem> void openItem(Object projectObject, final ClientStorageAccount storageAccount, final T item, String itemType, String itemName, String iconName);

    void openItem(@NotNull Object projectObject, @NotNull Object itemVirtualFile);

    void refreshQueue(@NotNull Object projectObject, @NotNull ClientStorageAccount storageAccount, @NotNull Queue queue);

    void refreshBlobs(@NotNull Object projectObject, @NotNull ClientStorageAccount storageAccount, @NotNull BlobContainer container);

    void refreshTable(@NotNull Object projectObject, @NotNull ClientStorageAccount storageAccount, @NotNull Table table);

    String promptForOpenSSLPath();

    @Nullable
    <T extends StorageServiceTreeItem> Object getOpenedFile(@NotNull Object projectObject,
                                                            @NotNull ClientStorageAccount storageAccount,
                                                            @NotNull T item);

    void saveWebAppPreferences(@NotNull Object projectObject, Map<WebSite, WebSiteConfiguration> map);
}