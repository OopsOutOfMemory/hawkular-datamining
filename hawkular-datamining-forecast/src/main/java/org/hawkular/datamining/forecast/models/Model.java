/*
 * Copyright 2015-2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hawkular.datamining.forecast.models;

/**
 * @author Pavol Loffay
 */
public enum Model {
    SimpleExponentialSmoothing(org.hawkular.datamining.forecast.models.SimpleExponentialSmoothing.class,
            org.hawkular.datamining.forecast.models.SimpleExponentialSmoothing.Optimizer.class),
    DoubleExponentialSmoothing(org.hawkular.datamining.forecast.models.DoubleExponentialSmoothing.class,
            org.hawkular.datamining.forecast.models.DoubleExponentialSmoothing.Optimizer.class),
    TripleExponentialSmoothing(org.hawkular.datamining.forecast.models.TripleExponentialSmoothing.class,
            org.hawkular.datamining.forecast.models.TripleExponentialSmoothing.Optimizer.class);

    private final Class<? extends TimeSeriesModel> model;
    private final Class<? extends ModelOptimizer> optimizer;


    Model(Class<? extends TimeSeriesModel> model, Class<? extends ModelOptimizer> optimizer) {
        this.optimizer = optimizer;
        this.model = model;
    }

    public boolean isOptimizedBy(ModelOptimizer optimizer) {
        return this.optimizer.isInstance(optimizer);
    }

    public Class<? extends TimeSeriesModel> getModel() {
        return model;
    }

    public Class<? extends ModelOptimizer> getOptimizer() {
        return optimizer;
    }
}
