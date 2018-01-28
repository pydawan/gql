package gql.ratpack;

import com.google.inject.Scopes;
import ratpack.guice.ConfigurableModule;

/**
 * Configures GraphQL and GraphiQL handler instances
 *
 * import static ratpack.groovy.Groovy.ratpack
 *
 * import gql.ratpack.GraphQLHandler
 * import gql.ratpack.GraphiQLHandler
 *
 * ratpack {
 *   bindings {
 *     module(GraphQLModule)
 *   }
 *   handlers {
 *     prefix('graphql') {
 *       post(GraphQLHandler)
 *       prefix('browser') {
 *         get(GraphiQLHandler)
 *       }
 *     }
 *   }
 * }
 *
 * @since 0.2.0
 */
public class GraphQLModule extends ConfigurableModule<GraphQLModuleConfig> {

  @Override
  public void configure() {
    bind(GraphQLHandler.class).in(Scopes.SINGLETON);
    bind(GraphiQLHandler.class).in(Scopes.SINGLETON);
  }
}
