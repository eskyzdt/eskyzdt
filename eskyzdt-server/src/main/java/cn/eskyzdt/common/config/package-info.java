/*
 * Copyright (c) 2019-2029, Dreamlu 卢春梦 (596392912@qq.com & www.dreamlu.net).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * 注意这两个注解只能放在package-info.java文件中
 */
@NonNullApi
@NonNullFields
package cn.eskyzdt.common.config;

import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;
/**
 *     @NonNull,用于注解方法，参数以及变量，指示目标对象不能为null；
 *
 *     @NonNullApi，包（Package）级别注解，指定参数和方法返回值默认不能为null；
 *
 *     @NonNullFields，包（Package）级别注解，用于变量不能为null；
 *
 *     @Nullable，可用于注解方法，参数以及变量，指定目标对象可以为null，若是与@NonNullApi和@NonNullFields共用时，则会覆盖
 */