package com.dgk.mvvm.activity.src.app_package

import java.util.*

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:27
 * @email dingguangkuo@163.com
 */
fun mvvmPageViewModelKt(packageName: String, className: String, itemClassName: String) = """
package $packageName

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dgk.common.base.BasePageViewModel
import com.dgk.common.data.RepositoryFactory
import com.dgk.common.data.repository.IDataRepository

/**
 *
 * @author Guangkuo
 * @date ${Date()}
 * @email dingguangkuo@163.com
 */
class ${className}ViewModel(
    repository: IDataRepository<${itemClassName}VO>, savedStateHandle: SavedStateHandle
) : BasePageViewModel<${itemClassName}VO>(repository = repository, savedStateHandle = savedStateHandle) {

    /**
     * 构造工厂
     */
    class ViewModelFactory(owner: SavedStateRegistryOwner) : AbstractSavedStateViewModelFactory(owner, null) {
        override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
            val repo = RepositoryFactory.getInstance().getRepository(ServiceApi.getInstance()::???, Entity2${itemClassName}Mapper())
            @Suppress("UNCHECKED_CAST")
            return ${itemClassName}ViewModel(repo, handle) as T
        }
    }
}
"""