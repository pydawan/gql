package gql.ratpack;

import gql.ratpack.GraphQLModuleConfig;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import ratpack.handling.Handler;
import ratpack.handling.Context;

/**
 * GraphiQL endpoint. This handler will be exposing a given GraphiQL
 * client.
 *
 * By default the handler is disable, so in order to enable it you
 * should set the {@link GraphQLModule.Config}#activateGraphiQL to
 * true when enabling the module
 *
 * @since 0.2.0
 */
public class GraphiQLHandler implements Handler {

  @Override
  public void handle(Context ctx) throws Exception {
    GraphQLModuleConfig config = ctx.get(GraphQLModuleConfig.class);

    if (config.activateGraphiQL) {
      ctx.render(getGraphiQLFile());
    } else {
      ctx.getResponse().status(404);
      ctx.getResponse().send();
    }
  }

  private Path getGraphiQLFile() throws URISyntaxException {
    URL url = GraphiQLHandler.class.getResource("/static/index.html");
    Path path = PathUtil.toPath(url);

    return path;
  }
}
