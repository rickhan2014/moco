package com.github.dreamhead.moco.handler;

import com.github.dreamhead.moco.HttpProtocolVersion;
import com.github.dreamhead.moco.HttpRequest;
import com.github.dreamhead.moco.MutableHttpResponse;
import com.github.dreamhead.moco.resource.Resource;

import static com.google.common.base.Optional.of;

public class VersionResponseHandler extends AbstractHttpResponseHandler {
    private final Resource resource;

    public VersionResponseHandler(final Resource resource) {
        this.resource = resource;
    }

    @Override
    protected void doWriteToResponse(HttpRequest httpRequest, MutableHttpResponse httpResponse) {
        String version = new String(resource.readFor(of(httpRequest)));
        httpResponse.setVersion(HttpProtocolVersion.versionOf(version));
    }
}
